/**
 * 
 */
package com.n26.helper;

import java.time.Instant;

//import de.nsmolenskii.experiments.n26.exceptions.InvalidTimestampException;

/**
 * @author Saurav
 *
 */
public final class N26Util {

	public static boolean isValidTimeStamp(final Long time) {
		return (Instant.now().toEpochMilli() - time) > 60000 ? false : true;
	}

}
