/*
 * Copyright 2009 David Linsin
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bhirava.ovilearning.ui.util;

import java.util.Arrays;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Base class containing methods used by all flavors of browsers
 *
 * @author David Linsin - dlinsin@gmail.com
 */
public abstract class RestClientBase {
    /**
     * Used to initialize the {@link RestTemplate} instance used to browse, with a {@link MappingJacksonHttpMessageConverter}
     *
     * @return {@link RestTemplate} instance
     */
    protected RestTemplate initTemplate() {
        RestTemplate template = new RestTemplate();
//        MappingJacksonHttpMessageConverter jsonConverter = new MappingJacksonHttpMessageConverter();
//        jsonConverter.getObjectMapper().configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        HttpMessageConverter<?>[] httpMessageConverters = new HttpMessageConverter<?>[] {jsonConverter};
//        template.setMessageConverters(Arrays.asList(httpMessageConverters));
        return template;
    }
}
