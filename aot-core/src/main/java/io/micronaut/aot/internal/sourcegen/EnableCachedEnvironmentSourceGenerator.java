/*
 * Copyright 2017-2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.aot.internal.sourcegen;

import com.squareup.javapoet.MethodSpec;
import io.micronaut.core.optim.StaticOptimizations;

import java.util.Optional;

/**
 * Generates the code used to enable environment variables and system
 * properties caching in Micronaut.
 */
public class EnableCachedEnvironmentSourceGenerator extends AbstractSourceGenerator {
    public EnableCachedEnvironmentSourceGenerator(SourceGenerationContext context) {
        super(context);
    }

    @Override
    public Optional<MethodSpec> generateStaticInit() {
        return staticMethod("enableEnvironmentCaching", body ->
                body.addStatement("$T.cacheEnvironment()", StaticOptimizations.class));
    }
}
