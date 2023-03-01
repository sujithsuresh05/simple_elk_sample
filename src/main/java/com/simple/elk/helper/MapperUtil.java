package com.simple.elk.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;

public class MapperUtil {

	/**
	 *  generic function to handle common mapping functionality
	 * @param <S> sorce class type
	 * @param <T> target class type
	 * @param source actual object
	 * @param target actual target class type
	 * @param modelMapper convertin gmapper object
	 * @return list of object of type target class
	 */
	public static <S, T> List<T> mapUtil(@NonNull List<S> source,@NonNull final Class<T> target,@NonNull final ModelMapper modelMapper) {
		return source.stream().map(element -> modelMapper.map(element, target)).collect(Collectors.toList());
	}

}
