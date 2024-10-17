package com.example.demo.sevice;

import com.example.demo.entity.Attribute;
import com.example.demo.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    public Attribute createAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    public Attribute getAttributeById(Long id) {
        return attributeRepository.findById(id).orElse(null);
    }

    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    public void deleteAttribute(Long id) {
        attributeRepository.deleteById(id);
    }
}
