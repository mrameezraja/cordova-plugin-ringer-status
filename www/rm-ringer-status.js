
    var exec = require('cordova/exec');

    var RMRinger = function () {

        }

        RMRinger.prototype = {
            getStatus: function (sc, ec) {
                exec(sc, ec, 'CDVRMRinger', 'getStatus', []);
            },
            vibrate: function () {
                exec(null, null, 'CDVRMRinger', 'vibrate', []);
            }
        }

    module.exports = new RMRinger();
