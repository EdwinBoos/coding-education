
# Import from own module "training.multiple_py_files.external" which points
# to external.py file in the current directory.
from training.module.external import Log

Log().add_text("Hello").add_text("World!").write() 

# As a more worse alternative you can use: import training.module.external
# Then you got to create an instance like so : training.module.external.Log()
