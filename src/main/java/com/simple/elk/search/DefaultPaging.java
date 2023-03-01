package com.simple.elk.search;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Will be used as default pageable implementation
 * @author sujiths
 *
 */
public enum DefaultPaging implements Pageable{
	
	INSTANCE;

	@Override
	public boolean isPaged() {
		return true;
	}

	@Override
	public Pageable previousOrFirst() {
		return this;
	}

	@Override
	public Pageable next() {
		return this;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public Sort getSort() {
		return Sort.unsorted();
	}

	@Override
	public int getPageSize() {
		return 10;
	}

	@Override
	public int getPageNumber() {
		return 0;
	}

	@Override
	public long getOffset() {
		return this.getPageNumber() * this.getPageSize();
	}

	@Override
	public Pageable first() {
		return this;
	}

	@Override
	public Pageable withPage(int pageNumber) {

		if (pageNumber == 0) {
			return this;
		}

		throw new UnsupportedOperationException();
	}

}
