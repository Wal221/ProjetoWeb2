package com.wingsupenglishacademy.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destinationClass) {
       return mapper.map(origin, destinationClass);
    }

    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destinationClass) {
        List<D> destinationObjects = new ArrayList<>();
        for (O originObject : origin) {
            destinationObjects.add(mapper.map(originObject, destinationClass)); //para cada objeto de origem eu converto com o mapper e adiciono no destino
        }
       return destinationObjects;
    }
}
