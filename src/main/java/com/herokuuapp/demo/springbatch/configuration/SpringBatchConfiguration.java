package com.herokuuapp.demo.springbatch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.herokuuapp.demo.springbatch.domain.FileBean;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfiguration {
     @Bean
     public Job job(JobBuilderFactory jobBuilderFactory, 
    		 StepBuilderFactory stepBuilderFactory,
    		 ItemReader<FileBean> itemReader,
    		 ItemProcessor<FileBean, FileBean> itemProcessor,
    		 ItemWriter<FileBean> itemWriter){
    	 Step step = stepBuilderFactory.get("noface-step")
    			 .<FileBean, FileBean>chunk(100)
    			 .reader(itemReader)
    			 .processor(itemProcessor)
    			 .writer(itemWriter)
    			 .build();
    	 return jobBuilderFactory.get("noface")
    	     .incrementer(new RunIdIncrementer())
    	     .start(step)
    	     .build();
     }
     
     @Bean
     public FlatFileItemReader<FileBean> itemReader(@Value("${input}") Resource resource){
    	 FlatFileItemReader<FileBean> flatFileItemReader = new FlatFileItemReader<>();
    	 flatFileItemReader.setResource(resource);
    	 flatFileItemReader.setName("csv-reader");
    	 flatFileItemReader.setLinesToSkip(1);
    	 flatFileItemReader.setLineMapper(lineMapper());
    	 return flatFileItemReader;
     }

	public LineMapper<FileBean> lineMapper() {
		DefaultLineMapper<FileBean> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"id","fileName","userLocation","userEmail"});
		
		BeanWrapperFieldSetMapper<FileBean> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(FileBean.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}
}
