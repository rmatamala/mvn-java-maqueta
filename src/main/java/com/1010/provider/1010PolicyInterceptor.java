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

import org.apache.tuscany.sca.interfacedef.Operation;
import org.apache.tuscany.sca.invocation.Invoker;
import org.apache.tuscany.sca.invocation.Message;
import org.apache.tuscany.sca.invocation.PhasedInterceptor;

/**
 * Policy handler to handle PolicySet related to Logging with the QName
 * {http://tuscany.apache.org/xmlns/sca/1.1/impl/java}1010Policy
 *
 * @version $Rev$ $Date$
 */
public class 1010PolicyInterceptor implements PhasedInterceptor {
    private Invoker next;
    private Operation operation;
    private String context;
    private String phase;
    
    public 1010PolicyInterceptor(String context, Operation operation, String phase) {
        super();
        this.operation = operation;
        this.context = context;
        this.phase = phase;
    }

    @Override
    public Message invoke(Message msg) {
        // DO SOMETHING HERE
        System.out.println("Inside policy interceptor invoke method");
        
        return getNext().invoke(msg);
    }

    @Override
    public Invoker getNext() {
        return next;
    }

    @Override
    public void setNext(Invoker next) {
        this.next = next;
    }

    @Override
    public String getPhase() {
        return phase;
    }

}
