import 'package:flutter/material.dart';
import 'package:p2_flutter/models/Heroi.dart';
import 'package:p2_flutter/models/RespostaAPI.dart';
import 'package:p2_flutter/utility/network_helper.dart';


class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  var _listaAnimes = ["Shimoneta","Love is War","Boku no Hero", "Noragami"];
  final _controlador = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        appBar: AppBar(title: Text("BokuNoWiki"),centerTitle: true,),
        body: Column(
          children: [
          customTextField(_controlador, "", "URL:", Icons.search),
            FlatButton(onPressed: ()async{
              var _req = NetworkHelper(url:"https://myheroacademiaapi.com/api/character?alias=deku");
              var _resp = RespostaAPI.fromJson(await _req.getData());
              print(_resp.result.first.name);
            }, child: Text("Buscar")),
            Expanded(
              child: ListView.builder(

                  itemBuilder: (context, index){
                    return ListTile(
                      title: Text(_listaAnimes[index]));
                  },
                itemCount: _listaAnimes.length,
              ),
            )



          ],
        ),
      ),
    );
  }

  Padding customTextField(TextEditingController controlador, String hint, String label, IconData icone) {
    return Padding(
      padding: const EdgeInsets.all(4.0),
      child: TextField(controller: controlador,decoration: InputDecoration(
          hintText: hint,
          labelText: label,
          icon: Icon(icone)
      ),),
    );
  }
}