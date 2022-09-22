
# JLogo

A logo language interpreter


## Examples

#### Example 1
![example1]()
```css
setpencolor 255 139 15
repeat 12 [ repeat 75 [ fd 100 bd 100 rt 2 ] fd 250 ]
```
#### Example 2
![example2]()
```css
setfillcolor 143 255 58
setscreencolor 255 71 214
setpencolor 0 39 255
repeat 400 [ repeat 34 [ fd 12 rt 10 ] rt 90 ]
```

#### Example 3
![example3]()
```css
setpencolor 166 23 255
repeat 24 [ repeat 25 [ fd 50 bd 50 rt 15 ] fd 50 ]
```


## Running

###### Interactive
```bash
./gradlew --console plain :api:run
```
In the interactive mode we can pass instructions by file or by console.

##### Gui
```bash
./gradlew :ui:run
```
In the gui mode instructions can be passed only via file.
## Available instructions
- FORWARD
    ```css
    FORWARD <distance>
    FORWARD 10
    FD 10
    ```
- BACKWARD 
    ```css
    BACKWARD <distance>
    BACKRWARD 10
    BD 10
    ```
- LEFT
    ```css
    LEFT <angle>
    LEFT 10
    LT 10
    ```
- RIGHT
    ```css
    RIGHT <angle>
    RIGHT 10
    RT 10
    ```
- CLEARSCREEN
    ```css
    CLEARSCREEN
    CS
    ```
- HOME
    ```css
    HOME
    ```
- PENUP
    ```css
    PENUP
    PU
    ```
- PENDOWN
    ```css
    PENDOWN
    PD
    ```
- SETPENCOLOR
    ```css
    SETPENCOLOR <byte> <byte> <byte>
    SETPENCOLOR 255 255 255
    ```
- SETSCREENCOLOR
    ```css
    SETSCREENCOLOR <byte> <byte> <byte>
    SETSCREENCOLOR 255 255 255
    ```
- SETPENSIZE
    ```css
    SETPENSIZE <size>
    SETPENCOLOR 10
    ```
- REPEAT
    ```css
    REPEAT [ <instructions> ]
    REPEAT 4 [ FORWARD 10 RIGHT 90 ]
    REPEAT 4 [ FD 10 REPEAT 4 [ FD 20 RT 10 ] FD 50 ]
    ```

