var dosbox = new Dosbox({
        id: "dosbox",
        onload: function (dosbox) {   dosbox.run("./DOOM/DOOM.EXE");
        },
        onrun: function (dosbox, app) {
          console.log("App '" + app + "' is runned");
        }
      });