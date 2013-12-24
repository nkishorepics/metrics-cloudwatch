/**
 * Copyright 2013 BlackLocus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blacklocus.metrics;

import com.codahale.metrics.Gauge;

import java.util.concurrent.atomic.AtomicReference;

/**
 * A thread-safe {@link Gauge} implementation for any sort of Number.
 *
 * @author Jason Dunkelberger (dirkraft)
 */
public class NumberGauge implements Gauge<Number> {

    private final AtomicReference<Number> value;

    /**
     * Initialized with value of 0.
     */
    public NumberGauge() {
        this(0);
    }

    public NumberGauge(Number initialValue) {
        value = new AtomicReference<Number>(initialValue);
    }

    @Override
    public Number getValue() {
        return value.get();
    }

    public void setValue(Number n) {
        this.value.set(n);
    }
}
