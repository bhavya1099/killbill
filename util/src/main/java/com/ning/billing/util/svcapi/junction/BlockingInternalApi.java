/*
 * Copyright 2010-2012 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.util.svcapi.junction;

import java.util.List;
import java.util.UUID;

import com.ning.billing.entitlement.api.Blockable;
import com.ning.billing.entitlement.api.BlockingState;
import com.ning.billing.util.callcontext.InternalCallContext;
import com.ning.billing.util.callcontext.InternalTenantContext;

public interface BlockingInternalApi {

    public BlockingState getBlockingStateFor(Blockable overdueable, InternalTenantContext context);

    public BlockingState getBlockingStateFor(UUID overdueableId, InternalTenantContext context);

    public List<BlockingState> getBlockingHistory(Blockable overdueable, InternalTenantContext context);

    public List<BlockingState> getBlockingHistory(UUID overdueableId, InternalTenantContext context);

    public <T extends Blockable> void setBlockingState(BlockingState state, InternalCallContext context);

}
