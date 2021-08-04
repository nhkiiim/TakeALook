const PARTICIPANT_MAIN_CLASS = 'participant main';
const PARTICIPANT_CLASS = 'participant';
/**
 * Creates a video element for a new participant
 *
 * @param {String} name - the name of the new participant, to be used as tag
 *                        name of the video element.
 *                        The tag of the new element will be 'video<name>'
 * @return
 */
export default function Participant(name) {
	this.name = name;
	var container = document.createElement('div');
	container.className = isPresentMainParticipant() ? PARTICIPANT_CLASS : PARTICIPANT_MAIN_CLASS;
	container.id = name;
	var span = document.createElement('span');
	var video = document.createElement('video');
	var rtcPeer;
  // let ws = new WebSocket(`wss://i5d101.p.ssafy.io:8443/groupcall`)

  	let ws = sessionStorage.getItem('ws')
  // ws.onclose = function(){
  //   console.log("web socket closed!!")
  //   setTimeout(function () {
  //     // web socket re-connect
  //     ws = new WebSocket(`wss://i5d101.p.ssafy.io:8443/groupcall`)
  //   }, 100)
  // }
	container.appendChild(video);
	container.appendChild(span);
	container.onclick = switchContainerClass;
	document.getElementById('participants').appendChild(container);

	span.appendChild(document.createTextNode(name));

	video.id = 'video-' + name;
	video.autoplay = true;
	video.controls = false;

  this.sendMessage = function(message) {
    var jsonMessage = JSON.stringify(message)
    console.log('Sending message: ' + jsonMessage)
    ws.send(jsonMessage)
    if (typeof callback !== 'undefined') {
      callback();
    }
  }

	this.getElement = function() {
		return container;
	}

	this.getVideoElement = function() {
		return video;
	}

	function switchContainerClass() {
		if (container.className === PARTICIPANT_CLASS) {
			var elements = Array.prototype.slice.call(document.getElementsByClassName(PARTICIPANT_MAIN_CLASS));
			elements.forEach(function(item) {
					item.className = PARTICIPANT_CLASS;
				});

				container.className = PARTICIPANT_MAIN_CLASS;
			} else {
			container.className = PARTICIPANT_CLASS;
		}
	}

	function isPresentMainParticipant() {
		return ((document.getElementsByClassName(PARTICIPANT_MAIN_CLASS)).length != 0);
	}

	this.offerToReceiveVideo = function(error, offerSdp, wp){
		if (error) return console.error ("sdp offer error")
		console.log('Invoking SDP offer callback function');
		var msg =  { id : "receiveVideoFrom",
				sender : name,
				sdpOffer : offerSdp
			};
		this.sendMessage(msg);
	}

	this.onIceCandidate = function (candidate, wp) {
		  console.log("Local candidate" + JSON.stringify(candidate));

		  var message = {
		    id: 'onIceCandidate',
		    candidate: candidate,
		    name: name
		  };
		  this.sendMessage(message);
	}

	Object.defineProperty(this, 'rtcPeer', { writable: true});

	this.dispose = function() {
		console.log('Disposing participant ' + this.name);
		this.rtcPeer.dispose();
		container.parentNode.removeChild(container);
  };

  function isOpen(ws){
    return ws.readyState === ws.OPEN
  }

  this.sendMessage = function(message) {
    var jsonMessage = JSON.stringify(message);
    console.log('Sending message: ' + jsonMessage);
      //if(isOpen(ws)) return
      if(ws.readyState != 1){
        ws = new WebSocket(`wss://i5d101.p.ssafy.io:8443/groupcall`)
      }
      waitForConnection(function(){
        // console.log(socket)
        console.log("socket state: "+ws.readyState)
        ws.send(jsonMessage)
        //console.log("send!")
        if (typeof callback !== 'undefined') {
          callback();
        }
      }, 2000)
      // ws.send(jsonMessage);
      // if (typeof callback !== 'undefined') {
      //   callback();
      // }
  }

  function waitForConnection(callback, interval) {
    if (ws.readyState === 1) {
      callback();
    } else {
      var that = this;
      // optional: implement backoff for interval here
      setTimeout(function () {
        console.log("websocket connecting...");
        waitForConnection(callback, interval);
      }, interval);
    }
  }

}
