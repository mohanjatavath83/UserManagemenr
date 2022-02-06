package com.user.populator;

public interface Populator<SOURCE,TARGET> {
	TARGET populate(SOURCE source);

}
