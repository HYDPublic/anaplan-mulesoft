/**
 * Copyright 2015 Anaplan Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License.md file for the specific language governing permissions and
 * limitations under the License.
 */

package com.anaplan.connector;


import com.anaplan.connector.exceptions.ConnectorPropertiesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;


/**
 * Parameter caching and validation.
 *
 * Validation supports any property value type, but convenience retrieval
 * methods only added for String as this is all we are currently using.
 */
public class AnaplanConnectorProperties {

	private static final Logger logger = LogManager.getLogger(
            AnaplanConnectorProperties.class.getName());

	private final HashMap<String, String> connectorProperties;

	/**
	 * Constructor.
	 */
	public AnaplanConnectorProperties() {
		connectorProperties = new HashMap<>();
	}

    /**
     * Sets connector properties using provided field-values and property-fields.
     *
     * @param fieldValues Array of field value strings.
     * @param requiredPropertyFields Array of property fields.
     * @throws ConnectorPropertiesException If length of field-values and
     *      required property values are of different length.
     */
	public void setProperties(String[] fieldValues,
			String... requiredPropertyFields) throws ConnectorPropertiesException {
		if (requiredPropertyFields != null) {
			if (fieldValues.length == requiredPropertyFields.length) {
				for (int i = 0; i < requiredPropertyFields.length; i++) {
					connectorProperties.put(requiredPropertyFields[i],
											fieldValues[i]);
				}
			} else {
				throw new ConnectorPropertiesException("Provided field-values "
						+ "and required property-fields are of different "
						+ "lengths!!");
			}
		}
		logger.trace("creating anaplan properties: {}", this);
	}

	/**
	 * Retrieve any required or optional property.
	 *
	 * @param propertyField Property field constant.
	 * @return value of the given property.
	 */
	public String getStringProperty(String propertyField) {
		logger.trace("getStringProperty({})", propertyField);
		return connectorProperties.get(propertyField);
	}
}
