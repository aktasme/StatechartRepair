/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_2
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_2.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "NC_2.h"
//## event evA()
#include "Default.h"
//## package _6_NestedConditions

//## class NC_2
NC_2::NC_2(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

NC_2::~NC_2() {
}

int NC_2::getX() const {
    return x;
}

void NC_2::setX(int p_x) {
    x = p_x;
}

bool NC_2::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void NC_2::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void NC_2::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus NC_2::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State A
    if(rootState_active == A)
        {
            if(IS_EVENT_TYPE_OF(evA_Default_id))
                {
                    //## transition 2 
                    if(x == 1)
                        {
                            rootState_subState = A;
                            rootState_active = A;
                            res = eventConsumed;
                        }
                    else
                        {
                            //## transition 3 
                            if(x == 2)
                                {
                                    //## transition 4 
                                    if(x == 3)
                                        {
                                            rootState_subState = B;
                                            rootState_active = B;
                                            res = eventConsumed;
                                        }
                                    else
                                        {
                                            rootState_subState = C;
                                            rootState_active = C;
                                            res = eventConsumed;
                                        }
                                }
                        }
                }
            
        }
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_2.cpp
*********************************************************************/
