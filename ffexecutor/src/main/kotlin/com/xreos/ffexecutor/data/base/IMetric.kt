package co.xreos.data.base

interface IMetric<X, Y> {
    fun getX(): X
    fun getY(): Y
}