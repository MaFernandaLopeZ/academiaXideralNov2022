package com.claseJava;

@FunctionalInterface
public interface Predicado<T> {

	abstract boolean probar(T t);
		
}
