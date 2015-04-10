package lib.unboundldap;

import com.unboundid.ldap.sdk.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: November 24, 2014
 * Time: 13:58
 */
public class Playground {


	public static void main(String... args) {

		try {
			LDAPConnectionOptions opts = new LDAPConnectionOptions();
			opts.setConnectTimeoutMillis(5000);

			LDAPConnection connection = new LDAPConnection(opts,
					"wiki.eng.centling.com", 389, "cn=admin,dc=centling,dc=com",
					"centling");

			System.out.println(connection.isConnected());

			//			LDAPResult ret = connection.modify("uid=xx,ou=people,dc=centling,dc=com",
			//					new Modification(ModificationType.REPLACE, "userPassword",
			// "123456"));
			//
			//			System.out.println(ret.getResultCode());

			SearchResultEntry entry = connection.getEntry("uid=xx,ou=people,dc=centling,dc=com");
			Attribute attr = entry.getAttribute("userPassword");

			 connection.modify("uid=xx,ou=people,dc=centling,dc=com", new Modification
					(ModificationType.REPLACE, "userPassword", ""));
			System.out.println(attr.getValue());

		} catch(LDAPException e) {

			System.out.println(e.getMessage());
		}

	}
}
