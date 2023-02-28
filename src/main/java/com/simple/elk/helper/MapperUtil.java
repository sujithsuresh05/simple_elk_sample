package com.simple.elk.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;

public class MapperUtil {

	public static <S, T> List<T> mapUtil(@NonNull List<S> source,@NonNull final Class<T> target,@NonNull final ModelMapper modelMapper) {
		return source.stream().map(element -> modelMapper.map(element, target)).collect(Collectors.toList());
	}

}
