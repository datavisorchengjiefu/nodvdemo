/*************************************************************************
 *
 * Copyright (c) 2016, DATAVISOR, INC.
 * All rights reserved.
 * __________________
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of DataVisor, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to DataVisor, Inc. and
 * may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from DataVisor, Inc.
 */

package com.example.springboot01.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        List<String> list = new ArrayList<>();
        list.add("s1");
        list.add("s2");
        list.add("s3");
        Map<String, List<String>> map = new HashMap<>();
        List<String> list01 = new ArrayList<>();
        list01.add("v1");
        list01.add("v2");
        list01.add("v3");
        list01.add("v4");
        map.put("key1", list01);
        List<String> list02 = new ArrayList<>();
        list02.add("v22");
        list02.add("v33");
        list02.add("v44");
        map.put("key2", list02);

        //        map.put("key1", "v1");
        //        map.put("key2", "v2");
        //        map.put("key3", "v3");
        //        map.put("key4", "v4");
        for (String s : list) {
            logger.info("s is {}. ", s);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                logger.info("entry is {}. ", entry.getKey());
                List<String> temp = new ArrayList<>();
                for (String s1 : entry.getValue()) {
                    logger.info("s1 is {}. ", s1);
                    if ("v2".equals(s1) || "v3".equals(s1)) {
                        temp.add(s1);
                    }
                }
                if (!temp.isEmpty()) {
                    entry.setValue(new ArrayList<>(temp));
                }
                logger.info("temp done. ");
            }
        }

    }
}
