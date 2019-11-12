package com.herokuuapp.demo.springbatch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.herokuuapp.demo.springbatch.domain.FileBean;

public class Processor implements ItemProcessor<FileBean, FileBean>{

	@Override
	public FileBean process(FileBean fileBean) throws Exception {
		return fileBean;
	}

}
