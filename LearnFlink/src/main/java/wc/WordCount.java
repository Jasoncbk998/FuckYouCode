package wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.UnsortedGrouping;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class WordCount {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> source = env.readTextFile("inputs/hello.txt");
        FlatMapOperator<String, Tuple2<String, Long>> datas = source.flatMap((String line, Collector<Tuple2<String, Long>> out) -> {
            String[] s = line.split(" ");
            for (String word : s) {
                out.collect(Tuple2.of(word, 1l));
            }
        }).returns(Types.TUPLE(Types.STRING, Types.LONG));

        UnsortedGrouping<Tuple2<String, Long>> datas2 = datas.groupBy(0);
        AggregateOperator<Tuple2<String, Long>> sum = datas2.sum(1);
        sum.print();

    }

    /**
     * 自定义
     */
    public class myFLatmapper implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> collector) throws Exception {
            String[] s = value.split(" ");
            for (String word : s) {
                collector.collect(new Tuple2<>(word, 1));
            }
        }
    }
}

