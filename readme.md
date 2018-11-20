cordova-plugin-ringer-status
====================

Detects current status of device ringer & fires an event if status changed.

Installation
------------

<code> cordova plugin add https://github.com/mrameezraja/cordova-plugin-ringer-status </code>


Methods
-------
- cordova.plugins.ringer.getStatus
- cordova.plugins.ringer.vibrate


cordova.plugins.ringer.getStatus
-------------------------------------------

<pre>
<code>
  cordova.plugins.ringer.getStatus(function(isSilent){
    console.log('isSilent: %s', isSilent);
  }, function(error){
    console.log(error);
  })
</code>
</pre>

Readings:
- isSilent // true | false

cordova.plugins.ringer.vibrate
--------------------------------

<pre>
<code>
  cordova.plugins.ringer.vibrate();
</code>
</pre>


Supported Platforms
-------------------

- IOS
- Android


