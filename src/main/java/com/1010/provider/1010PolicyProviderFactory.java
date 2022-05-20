/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

package com.1010.provider;

import org.apache.tuscany.sca.assembly.Endpoint;
import org.apache.tuscany.sca.assembly.EndpointReference;
import org.apache.tuscany.sca.core.ExtensionPointRegistry;
import org.apache.tuscany.sca.provider.PolicyProvider;
import org.apache.tuscany.sca.provider.PolicyProviderFactory;
import org.apache.tuscany.sca.runtime.RuntimeComponent;

import com.1010.1010Policy;

/**
 * @version $Rev$ $Date$
 */
public class 1010PolicyProviderFactory implements PolicyProviderFactory<1010Policy> {
    private ExtensionPointRegistry registry;
    
    public 1010PolicyProviderFactory(ExtensionPointRegistry registry) {
        super();
        this.registry = registry;
    }

    /**
     * @see 1020.provider.PolicyProviderFactory#createImplementationPolicyProvider(1020.runtime.RuntimeComponent, 1020.assembly.Implementation)
     */
    @Override
    public PolicyProvider createImplementationPolicyProvider(RuntimeComponent component) {
        return new 1010ImplementationPolicyProvider(component);
    }

    /**
     * @see 1020.provider.PolicyProviderFactory#createReferencePolicyProvider(1020.runtime.RuntimeComponent, 1020.runtime.RuntimeComponentReference, 1020.assembly.Binding)
     */
    @Override
    public PolicyProvider createReferencePolicyProvider(EndpointReference endpointReference) {
        return new 1010ReferencePolicyProvider(endpointReference);
    }

    /**
     * @see 1020.provider.PolicyProviderFactory#createServicePolicyProvider(1020.runtime.RuntimeComponent, 1020.runtime.RuntimeComponentService, 1020.assembly.Binding)
     */
    @Override
    public PolicyProvider createServicePolicyProvider(Endpoint endpoint) {
        return new 1010ServicePolicyProvider(endpoint);
    }

    /**
     * @see 1020.provider.ProviderFactory#getModelType()
     */
    @Override
    public Class<1010Policy> getModelType() {
        return 1010Policy.class;
    }

}
