/**
 * Copyright 2017 Hortonworks.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package com.hortonworks.registries.auth;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.security.PrivilegedAction;
import java.util.Map;

/**
 * Login interface for authentication.
 */
public interface Login {

    /**
     * Configures this login instance.
     */
    void configure(Map<String, ?> configs, String loginContextName);

    /**
     * Performs login for each login module specified for the login context of this instance.
     */
    LoginContext login() throws LoginException;

    /**
     *  Execute a privileged action which respect to the login context of this instance.
     */
    <T> T doAction(PrivilegedAction<T> action) throws LoginException;

    /**
     * Closes this instance.
     */
    void close();
}
