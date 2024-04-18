package com.xreos.ffexecutor.data.base

interface IMetric<X, Y> {
    fun getX(): X
    fun getY(): Y
}