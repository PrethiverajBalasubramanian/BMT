package com.prethive.bmt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.prethive.bmt.entity.Seat;

@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer
{
	@Bean
	List<Seat> seats()
	{
		final List<Seat> seats = new ArrayList<>();
		
		for(String section : "A,B".split(","))
		{
			for(int row=1;row<=10;row++)
			{
				for(int column=1;column<=10;column++)
				{
					seats.add(new Seat(section, row, column));
				}
			}
		}
		
		return seats;
	}
	
	@Bean
    @Primary
    ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder)
	{
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }
}
