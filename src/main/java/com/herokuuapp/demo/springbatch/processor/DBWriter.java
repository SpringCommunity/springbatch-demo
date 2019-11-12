package com.herokuuapp.demo.springbatch.processor;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.herokuuapp.demo.springbatch.dao.FileRepository;
import com.herokuuapp.demo.springbatch.domain.FileBean;

@Component
public class DBWriter implements ItemWriter<FileBean> {
	@Autowired
	private FileRepository fileRepository;

	@Override
	public void write(List<? extends FileBean> files) throws Exception {
		fileRepository.saveAll(files);
	}

}
