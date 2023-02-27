package com.simple.elk.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class MapperUtil {

	public static <S, T> List<T> mapUtil(final List<S> source, final Class<T> target, final ModelMapper modelMapper) {
		return source.stream().map(element -> modelMapper.map(element, target)).collect(Collectors.toList());
	}

}
