package com.wzy.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

//默认情况下框架传给mapper的输入数据中，key是要处理文本的一行的起始偏移量，这一行的内容作为value
public class WCMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
	//mapreduce每读一行数据就调用一次该方法
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		
		//具体业务逻辑写在这个方法体中，而且我们业务要处理的数据已经被框架传入
		//key是这行数据的起始偏移量，value是这行文本的内容
		String line = value.toString();
		String[] words = StringUtils.split(line, ' ');
		
		for(String word : words){
			context.write(new Text(word),new LongWritable(1));
		}
	}
	
	
	
}
