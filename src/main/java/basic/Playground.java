package basic;

import basic.generic.ChainAction;

import static basic.generic.Condition.equal;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: August 19, 2014
 * Time: 9:43
 */
public class Playground {

	public static void main() {

		ChainAction action = new ChainAction();

		action.perform(equal());
	}
}
