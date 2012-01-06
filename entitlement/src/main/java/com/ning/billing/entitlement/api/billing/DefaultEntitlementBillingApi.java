/*
 * Copyright 2010-2011 Ning, Inc.
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

package com.ning.billing.entitlement.api.billing;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.ning.billing.account.api.Account;
import com.ning.billing.entitlement.api.user.Subscription;
import com.ning.billing.entitlement.api.user.SubscriptionBundle;
import com.ning.billing.entitlement.api.user.SubscriptionData;
import com.ning.billing.entitlement.api.user.SubscriptionFactory.SubscriptionBuilder;
import com.ning.billing.entitlement.api.user.SubscriptionTransition;
import com.ning.billing.entitlement.engine.dao.EntitlementDao;

public class DefaultEntitlementBillingApi implements EntitlementBillingApi {

    private final EntitlementDao dao;

    @Inject
    public DefaultEntitlementBillingApi(EntitlementDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public SortedSet<BillingEvent> getBillingEventsForSubscription(
            UUID accountId) {
        
        List<SubscriptionBundle> bundles = dao.getSubscriptionBundleForAccount(accountId);
        List<Subscription> subscriptions = new ArrayList<Subscription>();
        for (SubscriptionBundle bundle: bundles) {
            subscriptions.addAll(dao.getSubscriptions(bundle.getId()));
        }
        List<SubscriptionTransition> transitions = new ArrayList<SubscriptionTransition>();
        for (Subscription subscription: subscriptions) {
            transitions.addAll(subscription.getAllTransitions());
        }
        
        SortedSet<BillingEvent> result = new TreeSet<BillingEvent>();
        
        for (SubscriptionTransition transition : transitions) {
            result.add(createBillingEvent(transition));
        }
        return result;
    }
    
    public List<Account> getActiveAccounts() {
        return null;
    }

    private BillingEvent createBillingEvent(SubscriptionTransition transition) {
        
        return null;
    }

    @Override
    public void setChargedThroughDate(UUID subscriptionId, DateTime ctd) {
        SubscriptionData subscription = (SubscriptionData) dao.getSubscriptionFromId(subscriptionId);
        if (subscription == null) {
            new EntitlementBillingApiException(String.format("Unknown subscription %s", subscriptionId));
        }

        SubscriptionBuilder builder = new SubscriptionBuilder(subscription)
            .setChargedThroughDate(ctd)
            .setPaidThroughDate(subscription.getPaidThroughDate());
        dao.updateSubscription(new SubscriptionData(builder));
    }
}
