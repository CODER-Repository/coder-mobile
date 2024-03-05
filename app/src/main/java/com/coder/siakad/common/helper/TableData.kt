package com.coder.siakad.common.helper

class TableData<T>(private val objects: List<T>) {
    fun createTable(selector: (T) -> List<Any?>): List<List<String>> {
        return objects.map { obj ->
            selector(obj).map { it.toString() }
        }
    }
}