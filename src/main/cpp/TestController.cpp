#include "com_nulstudio_medicalcommunication_controller_TestController.h"
#include <string>
#include <Python.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_nulstudio_medicalcommunication_controller_TestController_nulDataBridgeSendCommunicationString
    (JNIEnv* env, jobject thiz, jstring input) {

    const char* str = env->GetStringUTFChars(input, NULL);

  	Py_Initialize();

  	PyObject* pModule = NULL;
  	PyObject* pFunc = NULL;
  	PyObject* pName = NULL;

  	PyRun_SimpleString("import sys");
  	PyRun_SimpleString("sys.path.append(\'/app/python/\')");

  	pModule = PyImport_ImportModule("CommunicationTest");
  	pFunc = PyObject_GetAttrString(pModule, "ComTest");

  	PyObject* pArgs = PyTuple_New(1);

  	PyTuple_SetItem(pArgs, 0, Py_BuildValue("s", str));

  	PyObject* pReturn = PyObject_CallObject(pFunc, pArgs);

  	const char* res = PyUnicode_AsUTF8(pReturn);

  	std::string s = res;

  	Py_Finalize();
  	env->ReleaseStringUTFChars(input, str);

  	return env->NewStringUTF(s.c_str());
}