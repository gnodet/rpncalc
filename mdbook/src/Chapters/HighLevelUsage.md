<img align="right" width="125" src="../Images/HighLevelUsage.png">

# High Level Usage

RPNCalc is a command line application that must be run from a console / command prompt.  Executing it with a `-h` (or `-?`) switch, or starting the program and entering the `h` (or `help` or `?`) command will display the in-program help page.  This page lists all of the commands and operands that can be used, but it is fairly terse  This can be viewed at the bottom of the `Introduction Chapter` of this guide. This document is meant as a more comprehensive guide.

There are various command line switches that can be used when starting the program as are detailed in the `Command Line Options Chapter`.  They generally exist so that aliases can be used to control several key parameters, most likely the `-l StackName` switch.

Once inside the program, you'll be presented a prompt where numbers, operands, and commands may be entered.  Numbers will be added to the stack which you can think of as an upside down stack of plates.  The top stack item (represented by `line1` in the program) is on the bottom.  You can think of this stack of plates as a Last In First Out (LIFO) approach.

For example, you could enter `2 [ENTER]` it would be in the `line1` position and would be on the top of the stack.  If you then enter `3 [ENTER]` the `2` would move up go `line2` and the `3` would then be on `line1` and be on the top of the stack.  You can then enter in an operand, such as `+` to perform the action on the items opn the top of the stack. To continue our example, pressing `+ [ENTER]` would take the top two items off of the stack, add them, and put the result back on top of the stack (`line1`).  

I've gone into this in more detail in the `What is an RPN Calculator Chapter` and elsewhere and it's fairly easy and intuitive.  Once you get the hang of it, you'll overwhelming regret having to use a standard calculator in the future. :)

#### Why is the stack "upside down?"

One question I get with RPNCalc is why is the top of the stack on the bottom?  The reason is that it's simply more intuitive.  The command line is on the bottom.  You are usually dealing with the top of the stack so having `line1` directly above makes sense.  Also, for some operations, the order is important (think subtraction or division).  Having `line1` "underneath" `line2` is easy to understand as that's how we learned to do subtraction.  `line1` is subtracted from `line2`.

### Decimals & Fractions

In RPNCalc, the stacks always store numbers as decimals.  You can, however, enter in fractions and they will be instantly converted to a decimal equivalent and added to the stack.

**Example:**

`1 5/16 [ENTER]` 

will add `1.3125` to the top of the stack (`line1`)

`14/8 [ENTER]` 

will add `1.75` to the stack

While you can never directly convert a decimal number on the stack back to a fraction, you can display an approximation of what the top of the stack (`line1`) value would be as a fraction.  You do have to decide on the smallest denominator that will be used (called the base.)  The default base is `64` which is the equivalent of `1/64` and will be used if no base is specified.  Use the `frac [base]` command to display the approximate fractional equivalent.  RPNCalc will simplify the fraction as much as it can so if `line1` is `0.5`, the command `frac 4` won't convert and display `2/4`.  The result would be `1/2`.  Also note that `frac [based]` is a display command and will not actually change the stack in any way.

**Example:**
`12.3456 [Enter]`
`frac [Enter]`

No base was entered, so use `64`. It will display `12 11/32`  RPNCalc converted it to `12 22/64` and then reduced it.

`1 3/64 [Enter]`
`frac 16 [Enter]`

will display `1 1/16` as that's as close as it could get with a granularity of 1/16.

`1 3/64 [ENTER]`
`frac 100000`

will display `1 293/6250`.  This is a closer approximation than using base 16.

## Operands, Numbers, and Commands

Numbers, whether decimal or fractions, can be entered on the command line and they get added to the stack.  That's fairly self explanatory.

Operands perform basic match functions on those numbers.

Commands do the more exciting things.  You can add the speed of light constant to the stack (`sol`) or PI (`pi`), take the sine of the number, add it to a memory slot, and then save that sequence of commands as a user defined function.  Most of the rest of this guide will be talking about the various RPNCalc commands.

Lastly, as of `v4.6.0`, the arrow keys can be used within RPNCalc.  Up/Down will move you through your historical entries, and Left/Right will move you within the current command line.  This is probably what you would have expected it to do as it behaves similar to common consoles.
