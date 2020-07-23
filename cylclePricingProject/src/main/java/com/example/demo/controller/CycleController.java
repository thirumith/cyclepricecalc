package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.execution.PriceExecutionQueue;
import com.example.demo.execution.PriceTest;
import com.example.demo.service.CyclePriceRequest;

@RestController
public class CycleController {

	@Autowired
	private PriceExecutionQueue priceExecutionQueue;
	
	@Autowired
	private PriceTest priceTest;
	
	@RequestMapping(value="/calculateBycycle", method=RequestMethod.POST)
	public void getBycyclePrice(@RequestBody List<CyclePriceRequest> cyclePriceRequestList){
		this.priceExecutionQueue.execute(cyclePriceRequestList);
	}
	
	
	@RequestMapping(value="v1/calculateBycycle", method=RequestMethod.POST)
	public void getBycyclePriceV1(@RequestBody List<CyclePriceRequest> cyclePriceRequestList){
		this.priceTest.execute(cyclePriceRequestList);
	}
	
//	@RequestMapping(value="/calculateBycycle", method=RequestMethod.POST)
//	public void getBycyclePrice(@RequestBody List<CyclePriceRequest> cyclePriceRequest){
//		Iterator<CyclePriceRequest> cyclePrice = cyclePriceRequest.iterator();
//		while(cyclePrice.hasNext()) {
//		Wheel wheel=cyclePrice.next().getWheel();
//		ChainAssembly chainAssembly = cyclePrice.next().getAssembly();
//		Frame frame =cyclePrice.next().getFrame();
//		Seating seating = cyclePrice.next().getSeating();
//		HandleandBreak handleandBreak = cyclePrice.next().getHandleandBreak();
//		CycleResponseEntity cycleResponseEntity = cycleService.calculateCyclePrice(frame, handleandBreak, seating, wheel, chainAssembly);
//		System.out.println("Frame Price = "+String.valueOf(cycleResponseEntity.getFrameprice()));
//		System.out.println("Handle Price = "+String.valueOf(cycleResponseEntity.getHandlePrice()));
//		System.out.println("Seat Price = "+String.valueOf(cycleResponseEntity.getSeatPrice()));
//		System.out.println("Wheel Price = "+String.valueOf(cycleResponseEntity.getWheelPrice()));
//		System.out.println("Chain Price = "+String.valueOf(cycleResponseEntity.getChainPrice()));
//		System.out.println("Bycycle Total Price = "+String.valueOf(cycleResponseEntity.getCycleTotalPice()));
//		}
//	}
}
