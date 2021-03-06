/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.elasticloadbalancingv2.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.elasticloadbalancingv2.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;

/**
 * SetSubnetsRequest Marshaller
 */

public class SetSubnetsRequestMarshaller implements Marshaller<Request<SetSubnetsRequest>, SetSubnetsRequest> {

    public Request<SetSubnetsRequest> marshall(SetSubnetsRequest setSubnetsRequest) {

        if (setSubnetsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<SetSubnetsRequest> request = new DefaultRequest<SetSubnetsRequest>(setSubnetsRequest, "AmazonElasticLoadBalancing");
        request.addParameter("Action", "SetSubnets");
        request.addParameter("Version", "2015-12-01");
        request.setHttpMethod(HttpMethodName.POST);

        if (setSubnetsRequest.getLoadBalancerArn() != null) {
            request.addParameter("LoadBalancerArn", StringUtils.fromString(setSubnetsRequest.getLoadBalancerArn()));
        }

        java.util.List<String> subnetsList = setSubnetsRequest.getSubnets();

        if (subnetsList != null) {
            if (subnetsList.isEmpty()) {
                request.addParameter("Subnets", "");
            } else {
                int subnetsListIndex = 1;

                for (String subnetsListValue : subnetsList) {
                    if (subnetsListValue != null) {
                        request.addParameter("Subnets.member." + subnetsListIndex, StringUtils.fromString(subnetsListValue));
                    }
                    subnetsListIndex++;
                }
            }
        }

        return request;
    }

}
