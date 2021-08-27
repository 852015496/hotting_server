package com.hetting.hottable.server.impl;


import com.hetting.hottable.entity.*;

import java.util.List;

public interface IConcentService {

    List<Concent> concentList(Concent concent) throws Exception;

    Integer addConcent(Concent concent) throws Exception;

    Integer deleteConcent(Integer concentId) throws Exception;

    Integer updateConcent(Concent concent) throws Exception;

    Concent updateConcentList(Concent concent) throws Exception;

    Integer addMaterMessage(UserVO userVO) throws Exception;

    List<Concent> concentTerm(Concent concent) throws Exception;

    Integer deleteAllConcent(List<String> id) throws Exception;

}
