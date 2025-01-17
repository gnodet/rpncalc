<img align="right" width="125" src="../Images/Constants.png">

# Constants

These commands simply take a defined constant and add that number to the top of the stack (`line1`).  There are not that many constants defined, but if there is a desire to add additional ones please me know.

To use a constant, simply run the command and the value of the requested constant will be added to the top of the stack / `line1`

|Constant|Description|
|--------|-----------|
|pi| [Archimedes' constant, or PI](https://en.wikipedia.org/wiki/Pi), is the name given to the ratio of the circumference of a circle to the diameter. `PI` inserts the value of PI onto the stack.  In RPNCalc, and Java in general, Pi is approximately `3.141592653589793`|
|phi| Insert [PHI](https://en.wikipedia.org/wiki/Golden_ratio), also known as the Golden Ratio, to the stack.  In RPNCalc, Phi is defined as `1.618033989`|
|euler| Euler's number is also known as the exponential growth constant. It is the base for natural logarithms and is found in many areas of mathematics. The command `euler` inserts [Euler's number (e)](https://en.wikipedia.org/wiki/E_(mathematical_constant)) onto the stack.  e is approximately `2.71828182845`|
|sol|Inserts the [speed of light](https://en.wikipedia.org/wiki/Speed_of_light), in meters per second, onto the stack in meters/second and is approximately `299,792,458 m/s`|

#### Note:

There is a limitation currently.  RPNCalc does not understand scientific notation.  Running a quick check, On my system, a Java Double has the following limits as defined by `Double.MAX_VALUE` and `Double.MIN_VALUE`.

- Max: 1.7976931348623157E308
- Min: 4.9E-324