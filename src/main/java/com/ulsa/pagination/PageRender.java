package com.ulsa.pagination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

    private String url;
	private Page<T> page;
	private int totalPages;
	private int elementsforPage;
	private int actualPage;
	private List<PageItem> pages;

	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();

		elementsforPage = 5;
		totalPages = page.getTotalPages();
		actualPage = page.getNumber() + 1;

		int start, end;
		if (totalPages <= elementsforPage) {
			start = 1;
			end = totalPages;
		} else {
			if (actualPage <= elementsforPage / 2) {
				start = 1;
				end = elementsforPage;
			} else if (actualPage >= totalPages - elementsforPage / 2) {
				start = totalPages - elementsforPage + 1;
				end = elementsforPage;
			} else {
				start = actualPage - elementsforPage / 2;
				end = elementsforPage;
			}
		}

		for (int i = 0; i < end; i++) {
			pages.add(new PageItem(start + i, actualPage == start + i));
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public void setPages(List<PageItem> pages) {
		this.pages = pages;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
    }
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevius() {
		return page.hasPrevious();
	}
    
}
