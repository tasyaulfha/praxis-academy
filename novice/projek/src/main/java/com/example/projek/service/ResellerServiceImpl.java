package com.example.projek.service;


import com.example.projek.model.Reseller;
import com.example.projek.repository.ResellerRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ResellerServiceImpl implements ResellerService{

    private ResellerRepository resellerRepository;

    public ResellerServiceImpl(ResellerRepository resellerRepository){
        this.resellerRepository=resellerRepository;
    }

    @Override
    public @NotNull List<Reseller> getAllResellers() {
        return resellerRepository.findAll();
    }

    @Override
    public Reseller getReseller( Long id) {
        return resellerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ID Reseller Salah"));

    }

    @Override
    public Reseller save(Reseller reseller) {
        return resellerRepository.save(reseller);
    }

    @Override
    public Reseller deleteReseller(Long id){
        Reseller reseller = resellerRepository.findById(id).orElse(null);
        return reseller;
    }
    @Override
    public Reseller updateReseller(Long id, Reseller reseller){
        resellerRepository.save(reseller);
        return reseller;
    }
}
