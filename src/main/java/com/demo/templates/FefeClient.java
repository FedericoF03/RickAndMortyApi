package com.demo.templates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class FefeClient<T> {

    private final Logger logger = LoggerFactory.getLogger(FefeClient.class);
    private final RestTemplate resTemplate;
    private final String baseUrl;
    private final Class<T> classType;

    public FefeClient(String baseUrl) {
        Class<?> superClass = getClass();
        Type[] type = ((ParameterizedType) superClass.getGenericSuperclass()).getActualTypeArguments();
        this.classType = (Class<T>) type[0];
        this.resTemplate = new RestTemplate();
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public RestTemplate getResTemplate() {
        return resTemplate;
    }


    public Logger getLogger() {
        return logger;
    }

    public String finalURL(String endpoint) {
        return "%s%s".formatted(baseUrl, endpoint);
    }


    public T getRequest(String endpoint) {
        if (endpoint.isEmpty() || baseUrl.isEmpty()) {
            throw new IllegalArgumentException("No se seteo algun argumento necesario.");
        }

        logger.info(resTemplate.exchange(finalURL(endpoint), HttpMethod.GET, null, classType).toString().replace(",", ", \n"));
        return resTemplate.exchange(finalURL(endpoint), HttpMethod.GET, null, classType).getBody();
    }
}