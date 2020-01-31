/*
 * Copyright 2020 OPS4J.
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
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.web.service.spi.config;

public interface LogConfiguration {

	Boolean isLogNCSAFormatEnabled();

	String getLogNCSAFormat();

	String getLogNCSARetainDays();

	Boolean isLogNCSAAppend();

	Boolean isLogNCSAExtended();

	Boolean isLogNCSADispatch();

	String getLogNCSATimeZone();

	String getLogNCSADirectory();

	Boolean isLogNCSALatency();

	Boolean isLogNCSACookies();

	Boolean isLogNCSAServer();

}