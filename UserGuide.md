### Primitives Examples
```java
String appId  = "com.bhaptics.sample";
String appName = "Sample Java App";

HapticPlayer hapticPlayer = 
  new HapticPlayerImpl(appId, appName);

// wait for connect established. 
// or you can use HapticPlayerCallback to check when the connection to the `bHaptics Player` is established.

// submit with DotPoint
hapticPlayer.submitDot("test", PositionType.VestBack, Arrays.asList(new DotPoint(motorIndex, 100), 200);


// submit with PathPoint
hapticPlayer.submitPath("test2", PositionType.VestFront,
        Arrays.asList(new PathPoint(0.5, 0.5, 100)),
        500);



// turnOff
hapticPlayer.turnOff("test2");

// turnOff All 
hapticPlayer.turnOff();

```


### Tact File Examples 
You can make your own tact files using [bHaptics Designer](https://designer.bhaptics.com)

_or_ 

You can download sample tact files [here.](https://github.com/bhaptics/haptic-guide) 


```java
// read a tact file using file IO
File file = new File(
                getClass().getClassLoader().getResource("Explosion.tact").getFile()
        );

String content = StringUtils.readFile(file);

// register tact file as key name 'test'

hapticPlayer.register("test", content);

// request to player 'test' in the bHaptics Player
hapticPlayer.submitRegistered("test");


// give variation on the tact file
hapticPlayer.submitRegistered("test", "test2",
                new RotationOption(180, 0),
                new ScaleOption(1, 1));
```


### Dispose haptic player 
This method is for closing connection to the bHaptics Player.
```java
// dispose hapticPlayer
hapticPlayer.dispose();

```