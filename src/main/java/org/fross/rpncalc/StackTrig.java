/******************************************************************************
 * RPNCalc
 * 
 * RPNCalc is is an easy to use console based RPN calculator
 * 
 *  Copyright (c) 2013-2021 Michael Fross
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *           
 ******************************************************************************/
package org.fross.rpncalc;

import java.util.Stack;

import org.fross.library.Output;
import org.fusesource.jansi.Ansi;

public class StackTrig {
	/**
	 * cmdTrig(): Calculate the trig functions. There was so much overlap in the functions I
	 * consolidated the operations together
	 * 
	 * @param cmd
	 * @param arg
	 */
	@SuppressWarnings("unchecked")
	public static void cmdTrig(String cmd, String arg) {
		// Save to undo stack
		Main.undoStack.push((Stack<Double>) Main.calcStack.clone());

		Double angle = null;

		// Ensure we have at least one value on the stack
		if (Main.calcStack.size() >= 1) {
			try {
				angle = Main.calcStack.pop();

				// Calculations are done in radians. Convert if 'rad' is not provided as a parameter
				if (arg.toLowerCase().charAt(0) != 'r') {
					Output.printColorln(Ansi.Color.RED, "ERROR: unknown " + cmd + " parameter: '" + arg + "'");
					Main.calcStack.push(angle);
					return;
				}
			} catch (StringIndexOutOfBoundsException ex) {
				angle = java.lang.Math.toRadians(angle);
			}

		} else {
			Output.printColorln(Ansi.Color.RED, "ERROR: Must be at least one item on the stack");
			return;
		}

		// Push the result back onto the stack
		switch (cmd) {
		case "tan":
			Main.calcStack.add(java.lang.Math.tan(angle));
			break;

		case "sin":
			Main.calcStack.add(java.lang.Math.sin(angle));
			break;

		case "cos":
			Main.calcStack.add(java.lang.Math.cos(angle));
			break;

		default:
			Output.printColorln(Ansi.Color.RED, "ERROR: Could not understand trig command: '" + cmd + "'");
			return;
		}
	}

	/**
	 * cmdArcTrig(): Calculate the arc Trig functions. There was so much overlap in the functions I
	 * consolidated
	 * 
	 * @param cmd
	 * @param arg
	 */
	@SuppressWarnings("unchecked")
	public static void cmdArcTrig(String cmd, String arg) {
		// Save to undo stack
		Main.undoStack.push((Stack<Double>) Main.calcStack.clone());

		Double result = null;
		Double originalValue = null;

		// Ensure we have at least one value on the stack
		if (Main.calcStack.size() >= 1) {
			originalValue = Main.calcStack.peek();

			// Calculate the arc trig function
			switch (cmd) {
			case "asin":
				result = java.lang.Math.asin(Main.calcStack.pop());
				break;

			case "acos":
				result = java.lang.Math.acos(Main.calcStack.pop());
				break;

			case "atan":
				result = java.lang.Math.atan(Main.calcStack.pop());
				break;

			default:
				Output.printColorln(Ansi.Color.RED, "ERROR: Could not understand trig command: '" + cmd + "'");
				Main.calcStack.push(originalValue);
				return;
			}
		} else {
			Output.printColorln(Ansi.Color.RED, "ERROR: Must be at least one item on the stack");
			return;
		}

		try {
			// Display value in degrees or if 'rad' is a parameter, as radians
			if (arg.toLowerCase().charAt(0) == 'r') {
				Main.calcStack.push(result);
			} else {
				Main.calcStack.push(originalValue);
				Output.printColorln(Ansi.Color.RED, "ERROR: unknown " + cmd + " parameter: '" + arg + "'");
			}

		} catch (StringIndexOutOfBoundsException ex) {
			Main.calcStack.push(java.lang.Math.toDegrees(result));
		}
	}

	/**
	 * cmdHypotenuse(): Calculates the hypotenuse by pulling the top two stack items and using them as
	 * the triangle legs
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static void cmdHypotenuse() {
		// Ensure we have something on the stack
		if (Main.calcStack.size() < 2) {
			Output.printColorln(Ansi.Color.RED, "ERROR:  There must be two items on the stack");
			return;
		}

		// Save to undo stack
		Main.undoStack.push((Stack<Double>) Main.calcStack.clone());

		// Pop the two values and push the hypotenuse back onto the stack
		Main.calcStack.push(java.lang.Math.hypot(Main.calcStack.pop(), Main.calcStack.pop()));
	}
}