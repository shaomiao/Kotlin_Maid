package com.project.domain

/**
 * Created by shaomiao on 2017/9/19.
 */
public interface Command<T> {
    fun execute():T
}