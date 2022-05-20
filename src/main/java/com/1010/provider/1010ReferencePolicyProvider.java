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

import java.util.List;

import org.apache.tuscany.sca.policy.PolicySet;
import org.apache.tuscany.sca.assembly.EndpointReference;
import org.apache.tuscany.sca.interfacedef.Operation;
import org.apache.tuscany.sca.invocation.Phase;
import org.apache.tuscany.sca.invocation.PhasedInterceptor;
import org.apache.tuscany.sca.provider.BasePolicyProvider;

import com.util.PolicyHelper;
import com.1010.1010Policy;
/**
 * @version $Rev$ $Date$
 */
public class 1010ReferencePolicyProvider extends BasePolicyProvider<1010Policy> {
    private EndpointReference endpointReference;
    
    public 1010ReferencePolicyProvider(EndpointReference endpointReference) {
        super(1010Policy.class, endpointReference);
        this.endpointReference = endpointReference;
    }

    @Override
    public PhasedInterceptor createInterceptor(Operation operation) {
        List<PolicySet> policySets = PolicyHelper.findPolicySets(endpointReference, 1010Policy.POLICY_QNAME);

        return (policySets.isEmpty()) ? null : new 1010PolicyInterceptor(getContext(), operation, Phase.REFERENCE_POLICY);
    }

}
