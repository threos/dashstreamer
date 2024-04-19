package co.xreos.ffexecutor.store

import co.xreos.ffexecutor.data.base.IMetric

class MetricStore {
    private val map: MutableMap<String, Map<String, List<IMetric<*, *>>>> = HashMap()

    fun addMetric(task: String, context: String, metric: IMetric<*, *>) {
        if (!map.containsKey(task)) {
            map[task] = HashMap()
        }
        val metricMap = map[task] as MutableMap
        if (!metricMap.containsKey(context)) {
            metricMap[context] = ArrayList()
        }
        val metricList = metricMap[context] as MutableList
        metricList.add(metric)
    }

    fun getMetrics(task: String, context: String): List<IMetric<*, *>> {
        return map[task]?.get(context) ?: emptyList()
    }

    fun getContexts(task: String): Map<String, List<IMetric<*, *>>> {
        return map[task] ?: emptyMap()
    }
}